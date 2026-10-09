# 🔍 Автоматический поиск папки, где лежит pom.xml
PROJECT_DIR := $(shell dirname $$(find . -name "pom.xml" -not -path "*/target/*" | head -n 1))

# 📦 Парсинг Group ID, Artifact ID и Main Class прямо из pom.xml или структуры проекта
ARTIFACT_ID := $(shell [ -f "$(PROJECT_DIR)/pom.xml" ] && xmllint --xpath "/*[local-name()='project']/*[local-name()='artifactId']/text()" $(PROJECT_DIR)/pom.xml 2>/dev/null || echo "my-app")
GROUP_ID    := $(shell [ -f "$(PROJECT_DIR)/pom.xml" ] && xmllint --xpath "/*[local-name()='project']/*[local-name()='groupId']/text()" $(PROJECT_DIR)/pom.xml 2>/dev/null || echo "com.example")
MAIN_CLASS  := $(GROUP_ID).App

# Параметры для инициализации нового проекта (если папки еще нет)
NEW_ARTIFACT_ID := my-app
NEW_GROUP_ID    := com.example

.PHONY: all init build test run clean help

# По умолчанию при вызове просто "make" — проект соберется и запустится
all: build run

# 🚀 1. Инициализация нового проекта (если вы начинаете с нуля)
init:
	@if [ -f "pom.xml" ] || [ -d "$(NEW_ARTIFACT_ID)" ]; then \
		echo "❌ Проект уже инициализирован!"; \
	else \
		mvn archetype:generate \
			-DgroupId=$(NEW_GROUP_ID) \
			-DartifactId=$(NEW_ARTIFACT_ID) \
			-DarchetypeArtifactId=maven-archetype-quickstart \
			-DarchetypeVersion=1.5 \
			-DinteractiveMode=false; \
	fi

# 📦 2. Сборка проекта (автоматически заходит в нужную папку)
build:
	@if [ -z "$(PROJECT_DIR)" ] || [ "$(PROJECT_DIR)" = "." ] && [ ! -f "pom.xml" ]; then \
		echo "❌ Ошибка: pom.xml не найден. Сначала запустите 'make init'"; exit 1; \
	fi
	cd $(PROJECT_DIR) && mvn clean compile package

# 🧪 3. Запуск тестов JUnit
test:
	cd $(PROJECT_DIR) && mvn test

# 🏃 4. Умный запуск скомпилированного .jar файла
run:
	cd $(PROJECT_DIR) && java -cp target/$(ARTIFACT_ID)-1.0-SNAPSHOT.jar $(MAIN_CLASS)

# 🧹 5. Очистка временных файлов сборки target/
clean:
	cd $(PROJECT_DIR) && mvn clean

# ℹ️ Справка по командам
help:
	@echo "Доступные команды:"
	@echo "  make init    - Создать структуру проекта Maven по умолчанию"
	@echo "  make build   - Скомпилировать код и собрать JAR"
	@echo "  make test    - Запустить тесты"
	@echo "  make run     - Запустить приложение"
	@echo "  make clean   - Удалить папку target"
	@echo "  make         - Собрать и сразу запустить (build + run)"
