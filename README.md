# Gestión de Empleados  - (Latest version)

Proyecto donde desarrollo un CRUD (Create, Read, Update, Delete) **Full Stack** usando **React** en el frontend y **Spring Boot** en el backend, con **MySQL** como base de datos.  


# Uso de la aplicación

La aplicación permite gestionar una lista de empleados.

- Frontend: El frontend proporciona una interfaz de usuario para:
Ver la lista de empleados, paginada y con la opción de buscar por nombre.
Registrar nuevos empleados.
Editar la información de empleados existentes.
Eliminar empleados.

- Backend: El backend expone una API RESTful que el frontend consume para realizar las operaciones CRUD (Crear, Leer, Actualizar, Borrar) sobre los datos de los empleados almacenados en la base de datos MySQL.
  
- Base de datos: La base de datos MySQL almacena la información de los empleados de forma persistente.


# Guía de instalación

1.Iniciar XAMPP:
  Inicia el Panel de Control de XAMPP.
  Arranca los servicios de Apache y MySQL.

2.Configurar la Base de Datos:
  Usando phpMyAdmin (accesible a través de XAMPP), crea la base de datos "empresa".

3.Construir la Aplicación Backend:
  Abre una terminal en la raíz del proyecto backend (GEM-BACKEND).
  Ejecuta ./mvnw clean package para construir la aplicación Spring Boot.

4.Ejecutar la Aplicación Backend:
  Abre el proyecto backend en Visual Studio Code.
  Abre el panel "Spring Boot Dashboard".
  Ejecuta la aplicación PruebaTecnicaMMC desde el dashboard.

5.Configurar y Ejecutar el Frontend:
  Abre una nueva terminal y navega al directorio del proyecto frontend.
  Ejecuta npm install para instalar las dependencias del frontend.
  Ejecuta npm run dev para iniciar el servidor de desarrollo de Vite.

6.Acceder a la Aplicación:
  El frontend estará disponible en el navegador en la URL proporcionada por Vite (normalmente http://localhost:5173).
  La aplicación frontend se comunicará con la API del backend que se ejecuta en http://localhost:8090.

Con estos pasos, la aplicación backend estará en ejecución y lista para recibir peticiones del frontend. Podrás administrar la base de datos MySQL mediante phpMyAdmin y ejecutar la aplicación Spring Boot directamente desde Visual Studio Code.
