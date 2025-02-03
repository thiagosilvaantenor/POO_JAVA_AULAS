rmdir /S /Q ".\build\"
mkdir build
javac -d ./build -cp .;./lib/mariadb-java-client-3.5.1.jar ./src/edu/curso/aula_16/model/*.java ./src/edu/curso/aula_16/persistence/*.java ./src/edu/curso/aula_16/control/*.java ./src/edu/curso/aula_16/view/*.java
java -cp .;./build;./lib/mariadb-java-client-3.5.1.jar %1