#Практичне завдання
Метою практичної роботи є отримання навичок розгортання та використання платформ інтелектуального аналізу даних.

Розглядаються етапи встановлення, налаштування та запуск тестового прикладу на базі фреймворку Apache Mahout.
Мінімальні вимоги для програмного забезпечення такі: Java 1.6.x або новіша; Maven 3.x, щоб мати можливість скомпілювати з вихідного коду (додатково).
Чітких апаратних вимог немає, адже є можливість налаштувати за допомогою конфігураційних файлів ресурси, які будуть виділятися. Також від апаратних потужностей може залежати час виконання прикладів.
За основу взято встановлення серверу Apache Mahout на Unix- подібну операційну систему.

Отже, ми будемо розглядати вже готовий фреймворк для інтелектуального аналізу даних - Apache Mahout (http://mahout.apache.org/).
https://cwiki.apache.org/confluence/display/MAHOUT/ RecommendationExamples - найпростіший приклад з готовим набором даних.

Можна скористатися даним туторіалом
https://www.datasciencecentral.com/profiles/blogs/how-to-install-and-run-hadoop-on-windows-for-beginners

Частина 1
1. Перш за все необхідно встановити такі програмні компоненти:
- Java, and the latest version of the JDK;
-SSH.
Перевірити установку Java можна за допомогою команди java- version.
2. Для коректної роботи серверу необхідно встановити платформу Apache Hadoop:
http://www.apache.org/dyn/closer.cgi/hadoop/common/
Звідси можна скачати дистрибутив або вихідні коди, які потім необхідно розархівувати, чи зібрати — якщо необхідна компіляція.
3. Конфігурація Apache Hadoop:

- hadoop-env.sh - у цьому файлі необхідно розкоментувати такі параметри:
 
    - export JAVA_HOME=<umKX до Java бібліотек>
    - export HADOOP_HEAPSIZE=2000 (величина максимального обсягу пам’яті, що буде виділений);

- далі ми маємо налаштувати параметри запуску Hadoop у файлах /conf/core-site.xml та /cont/mapred-site.xml
    - у /conf/core-site.xml прописуються параметри запуску, такі як тимчасова директорія для результатів роботи системи, визначення URI для файлової системи Hadoop та інші.
```xml
<configuration>
<property>
<name>hadoop.tmp.dir</name>
• value>/Users/hadoop/<tmpDir></value>
<description>A base for other temporary directories.</description> </property>
<property>
<name>fs.default.name</name>
<value>hdfs://localhost:9000</value>
<description>The name of the default file system. A URI whose scheme and authority determine the FileSystem implementation. The uri’s scheme determines the config property (fs.SCHEME.impl) naming
the FileSystem implementation class. The uri’s authority is used to determine the host, port, etc. for a filesystem.</description> </propcrty>
<property>
<name>dfs.replication</name>
<value> 1 </value>
<description>Default block replication.
The actual number of replications can be specified when the file is created.
The default is used if replication is not specified in create time. </description>
</property>
</configuration>
```

- у /conf/mapred-site.xml треба вставити параметри, які відповідають за відпрацювання процесу map-reduce.
```xml
<property>
<name>mapred.j ob.tracker</name>
<value>localhost:9001 </value>
<description>The host and port that the MapReduce job tracker runs at. If «local», then jobs are run in-process as a single map and reduce task.
</description>
</property>

<property>
<name>mapred.tasktracker.tasks.maximum</name>
<value>8</value>
<description>The maximum number of tasks that will be run simultaneously by a a task tracker </description>
</property>
```

4. Запуск і тестування:
- hadoop namenode-format (ця команда запускає форматування віртуальної файлової системи для Apache Hadoop);
- start-all.sh (ця команда запускає всі процеси).
Частина 2
Коли Apache Hadoop буде успішно встановлено й запущено, можна переходити до налаштування Apache Mahout.
1. Встановлення необхідних пакетів
- http://www.apache.org/dyn/closer.cgi/mahout/ - завантажити та розархівувати в зручну папку дистрибутив платформи;
- для запуску тестового прикладу необхідно завантажити також базу даних (http://www.grouplens.org/system/files/ml-100k.zip) — рекомендаційна база користувачів і кінофільмів.
2. Далі необхідно скопіювати основні дані:
- cd ml-100k
- hadoop fs -put u.data u.data
3. Запуск аналізу рекомендаційної інформації:
hadoop jar mahout-core-0.8-job.jar org.apache.mahout.cf.taste. hadoop.item.RecommenderJob -s SIMILARITY_COOCCURRENCE -input u.data —output output,
де mahout-core-0.8-job.jar - це версії завантаженої платформи Apache Mahout
4. Отримання результату.
За допомогою команди hadoop fs -getmerge output output.txt з файлової системи HDFS отримуються вихідні дані.
За допомогою скрипту з дод. 2 можна отримати зручний для розуміння формат.