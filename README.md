# PruebaIntro — Configuración de Java para este proyecto

Este proyecto incluye un script PowerShell `set-java-env.ps1` en la raíz que configura temporalmente `JAVA_HOME` y ajusta `PATH` para usar el JDK específico recomendado para trabajar con este proyecto.

Uso (PowerShell, desde la carpeta del proyecto):

1. Abre PowerShell y navega a la carpeta del proyecto (donde está `README.md` y `set-java-env.ps1`).

2. Aplica la configuración en la sesión actual con dot-sourcing (esto modifica las variables de entorno solo para la sesión actual):

```powershell
. .\set-java-env.ps1
```

3. Verifica Java y Maven:

```powershell
java -version
mvn -v
```

4. Ejecuta tests o compila el proyecto normalmente:

```powershell
mvn test
mvn package
mvn compile exec:java -Dexec.mainClass="org.sergiolozanoprofe.Main"
```

Notas importantes:
- El script solo afecta a la sesión actual de PowerShell; si cierras la consola y abres otra, tendrás que ejecutar de nuevo `. .\set-java-env.ps1` en esa nueva sesión.
- El script ha sido diseñado para evitar duplicar la ruta del JDK en `PATH` (normaliza y elimina entradas duplicadas antes de añadir el `bin`).


