rmdir /S /Q ".\build\"
mkdir build
javac -d ./build -cp .;./lib/mariadb-java-client-3.5.1.jar ./src/edu/curso/aula_14/persistence/*.java ./src/edu/curso/aula_14/view/*.java
java -cp .;./build;./lib/mariadb-java-client-3.5.1.jar %1