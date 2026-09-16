import numpy as np
import matplotlib.pyplot as plt
from flask import Flask, render_template, request
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error, r2_score

app = Flask(__name__)

superficie = np.array([
    35, 40, 45, 50, 55, 60,
    65, 70, 75, 80, 90, 100
]).reshape(-1, 1)

alquiler = np.array([
    1400, 1550, 1700, 1850, 2000, 2200,
    2350, 2500, 2700, 2900, 3200, 3500
])

x_entrenamiento, x_prueba, y_entrenamiento, y_prueba = train_test_split(
    superficie,
    alquiler,
    test_size=0.2,
    random_state=42
)

modelo = LinearRegression()

modelo.fit(x_entrenamiento, y_entrenamiento)

y_prediccion = modelo.predict(x_prueba)

pendiente = modelo.coef_[0]
intercepto = modelo.intercept_

error = mean_squared_error(y_prueba, y_prediccion)
r2 = r2_score(y_prueba, y_prediccion)


@app.route("/", methods=["GET", "POST"])
def inicio():

    prediccion = None
    metros = None

    if request.method == "POST":

        metros = float(request.form["metros"])

        prediccion = modelo.predict([[metros]])[0]

        plt.figure(figsize=(10, 6))

        # datos originales
        plt.scatter(
            superficie,
            alquiler,
            color="#5B8DEF",
            s=55,
            label="datos reales",
            zorder=3
        )

        # recta de regresión
        linea_x = np.linspace(
            superficie.min(),
            superficie.max(),
            100
        ).reshape(-1, 1)

        linea_y = modelo.predict(linea_x)

        plt.plot(
            linea_x,
            linea_y,
            color="#8B7CF6",
            linewidth=1.5,
            label="regresión lineal",
            zorder=2
        )

        # predicción ingresada por el usuario
        plt.scatter(
            metros,
            prediccion,
            color="#FF6B8A",
            marker="X",
            s=130,
            label="predicción",
            zorder=4
        )

        plt.xlabel(
            "superficie de la vivienda (m²)",
            fontsize=11
        )

        plt.ylabel(
            "precio de alquiler (Bs)",
            fontsize=11
        )

        plt.title(
            "regresión lineal: superficie vs precio de alquiler",
            fontsize=14,
            fontweight="bold"
        )

        plt.legend()

        plt.grid(
            True,
            alpha=0.25
        )

        plt.tight_layout()

        plt.savefig(
            "static/grafica.png",
            dpi=150,
            bbox_inches="tight"
        )

        plt.close()

    return render_template(
        "index.html",
        pendiente=pendiente,
        intercepto=intercepto,
        error=error,
        r2=r2,
        prediccion=prediccion,
        metros=metros
    )


if __name__ == "__main__":
    app.run(debug=True)