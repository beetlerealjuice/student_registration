# Работа с проектом в IntelliJ IDEA

"Учет студентов" представляет из себя консольное приложение, написанное на Spring Boot
(JAR-файл, запускаемый на любом сервере, компьютере, также через Docker), реализуемое через консольный ввод
командной строки Shell. Приложение имеет Dockerfile для создания докер-образа и запуска контейнера в Docker.

Приложение выполняет следующие задачи:

Выводит всех имеющихся студентов. Команда "ls", "list"
Добавляет нового студента. Команда на добавление принимает три поля и вводится в формате: "i имя фамилия возраст", 
где i - это init. Идентификатор (id) студента генерируется автоматически.

Удаляет студента по идентификатору (id). Команда вводится в формате: "delete"
Полностью очищает список студентов. Команда "cls", где с - это clear.
Имеет возможность создавать студентов при старте приложения, без команды. 
Эта функция может отключаться через application.yml с true на false.

- Создайте jar-файл проекта. Gradle -> bootJar
- В окне терминала Alt-F12 создайте Docker-образ командой docker build -t <имя_образа> . (на конце точка)
- Создайте и запустите Docker-контейнер на основе созданного образа командой docker run -it -p 8082:8082 -e STUDENT_INIT_ENABLED=true <имя_образа>
    параметр STUDENT_INIT_ENABLED=true отвечает за возможность инициализировать студентов при старте приложения
- Список доступных команд выводится в Spring Shell командой 'help'
- Для выхода из Spring Shell введите 'exit'
- Для выхода из терминала введите сочетание клавиш Ctrl+P Ctrl+Q (для Windows)
- Если программу запустить в контейнере в Docker Desktop, то Spring Shell не запустится.
    Не знаю почему. Буду рад предложениям! :-)

