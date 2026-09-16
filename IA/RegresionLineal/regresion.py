import numpy as np
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error, r2_score

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

print("==============================================")
print(" PREDICCIÓN DE ALQUILER DE VIVIENDAS - LA PAZ")
print("==============================================")

print("\nEcuación de regresión:")
print(f"y = {pendiente:.2f}x + {intercepto:.2f}")

print(f"\nCoeficiente R²: {r2:.4f}")
print(f"Error cuadrático medio: {error:.2f}")

metros = float(input("\nIngrese la superficie de la vivienda en m²: "))

prediccion = modelo.predict([[metros]])[0]

print(f"\nSuperficie ingresada: {metros:.2f} m²")
print(f"Precio estimado del alquiler: Bs {prediccion:.2f}")

plt.figure(figsize=(10, 6))

plt.scatter(
    superficie,
    alquiler,
    color="#5B8DEF",
    s=55,
    label="datos reales"
)

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
    label="regresión lineal"
)

plt.scatter(
    metros,
    prediccion,
    color="#FF6B8A",
    marker="X",
    s=130,
    label="predicción"
)

plt.xlabel("superficie de la vivienda (m²)")
plt.ylabel("precio de alquiler (Bs)")
plt.title("Regresión lineal: superficie vs precio de alquiler")
plt.legend()
plt.grid(True, alpha=0.25)
plt.tight_layout()

plt.show()