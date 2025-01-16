# Calculadora en Kotlin con Jetpack Compose

Esta es una aplicación Android simple desarrollada en **Kotlin** que permite al usuario realizar la suma de dos números. La interfaz gráfica se ha implementado utilizando **Jetpack Compose**, el moderno toolkit de UI de Android.

## Características

- **Interfaz gráfica**: Utiliza Jetpack Compose para definir los componentes de la interfaz de usuario de manera declarativa.
- **Funcionalidad**: Permite al usuario ingresar dos números, calcular su suma y mostrar el resultado en pantalla.
- **Validación de entrada**:
  - Solo permite números, un solo punto decimal (`.`) y un signo negativo (`-`) al principio.
  - Muestra mensajes de error si los campos están vacíos o contienen valores no válidos.
- **Precisión decimal**: El resultado se redondea al número de decimales del número con más decimales ingresado.

## Capturas de Pantalla

<p align="center">
  <img src="https://github.com/user-attachments/assets/0efa01c7-ff09-4e9e-bdcd-9500891c1535" alt="Error ambos inputs" style="height: 300px; width: auto;" />
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/25e856ab-8683-47f8-bbdb-7ed54238cf7a" alt="Error primer input" style="height: 300px; width: auto;" />
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/db0c35eb-68c2-4302-9d69-3d1a95afdd95" alt="Error segundo input" style="height: 300px; width: auto;" />
</p>


<p>
  <strong>Solo permite números, y un máximo de un <code>.</code> y un <code>-</code> solo al principio.</strong>
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/03ff84bd-5e81-4431-ac73-e51de5095f08" alt="Ejemplo de resultado sin decimales" style="height: 300px; width: auto;" />
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/91c2cea5-9431-4dc6-afdc-a9272d78cc14" alt="Ejemplo de resultado con 2 decimales" style="height: 300px; width: auto;" />
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/dbbff4f9-47d5-432b-a97b-b45f3dcb6b59" alt="Ejemplo de resultado con 5 decimales" style="height: 300px; width: auto;" />
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/ad31fec1-482a-4f2d-b972-f7bcb3fa22fe" alt="Ejemplo de resultado de suma de un negativo" style="height: 300px; width: auto;" />
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/b7920b75-fcb9-4c5f-8348-ae21501a7b44" alt="Ejemplo de resultado de suma de dos negativo" style="height: 300px; width: auto;" />
</p>



## Instrucciones de Compilación

1. Clona este repositorio en tu máquina local.
   ```bash
   git clone https://github.com/GiovanniJMDev/KotlinCalculator.git
   ```
   
2. Abre el proyecto en Android Studio.

3. Conecta un dispositivo Android o inicia un emulador.

4. Haz clic en el botón "Run" para compilar y ejecutar la aplicación.

5. Estructura del Proyecto
   5.1. **app/src/main/java/com/example/kotlincalculator/MainActivity.kt:** Contiene la lógica principal de la aplicación y la interfaz gráfica implementada con Jetpack Compose.
