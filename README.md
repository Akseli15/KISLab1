# Enterprise Information System (EIS)
# Корпоративные информационные системы

## Лабораторные работы

### Лабораторная работа №1: Создание компонента CDI

**Зависимости:**

Для корректной работы проекта необходимы следующие библиотеки:

- [Weld](https://weld.cdi.spec/) - реализация CDI для Java SE.
- [Lombok](https://projectlombok.org/) - библиотека для упрощения написания кода.


**Описание задания:**

Создать компонент CDI, выполняющий нахождение тангенса угла различными способами (по синусу и косинусу, только по косинусу). Выбор способа нахождения тангенса угла должен быть реализован через указание соответствующей аннотации или посредством указания класса в XML файле. Посредством перехватчиков провести сравнение по времени эффективности различных методов.

**Решение задания:**

Проект включает в себя реализацию калькулятора тангенса с использованием CDI для управления зависимостями и интерсептора для измерения времени выполнения методов. Основные компоненты проекта описаны ниже:

### Структура проекта

#### Главный Класс

- **Lab1Start**: Главный класс для инициализации CDI контейнера, создания экземпляра `TanCalculator`, и выполнения расчетов тангенса.

#### Интерсептор

- **ProfileInterceptor**: Интерсептор для измерения времени выполнения методов калькуляторов. Позволяет сравнить эффективность различных методов нахождения тангенса.

#### Аннотации

- **COSINE_ONLY**: Аннотация для обозначения калькулятора, работающего только с косинусом.
- **SINE_COSINE**: Аннотация для обозначения калькулятора, работающего с синусом и косинусом.

#### Параметры

- **TanParams**: Интерфейс для параметров калькулятора тангенса. Определяет метод `getValues()` для получения значений параметров.
- **CosOnlyParams**: Класс, представляющий параметры только с косинусом. Включает валидацию значения косинуса, проверяя, что оно находится в диапазоне [-1, 1] и не равно нулю.
- **SinCosParams**: Класс, представляющий параметры с синусом и косинусом. Проверяет, что синус и косинус находятся в диапазоне [-1, 1] и что косинус не равен нулю.

#### Интерфейсы и Классы

- **ITanCalculator**: Интерфейс для калькуляторов тангенса. Определяет метод `calculate()` для вычисления тангенса.
- **CosOnlyCalculator**: Класс, реализующий `ITanCalculator`, работающий только с косинусом. Аннотирован аннотацией `COSINE_ONLY`.
- **SinCosCalculator**: Класс, реализующий `ITanCalculator`, работающий с синусом и косинусом. Аннотирован аннотацией `SINE_COSINE`.

