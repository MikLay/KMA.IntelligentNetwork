Проаналізуйте та спробуйте реалізувати такі завдання:
1. Запишіть RIF-правило, яке б описувало твердження «Усі люди смертні». 
```
Document(
Prefix (bio chttp: //example . com/biology#>)
Group(
Forall ?X (
If bio:human(?X)
Then bio:mortal(?X)
)
)
)
```



2. Запишіть RIF-правило, яке б описувало твердження «Якщо Со- крат людина, то Сократ смертний». 
```
Document(
Prefix (bio <http: //example. com/biology#>)
Prefix (phil <http: //example. com/philosophers#>)
Group(
If bio:human(phil:Socrates)
Then bio:mortal(phil:Socrates)
)
)
```

3. Запишіть RIF-правило, яке б описувало твердження «Всі люди смертні, Сократ - людина» (modus ponens; RIF автоматично виведе «Якщо Сократ людина, то Сократ смертний»). 
```
Document(
Prefix (bio chttp: //example. com/biology#>)
Prefix(phil <http://example.com/philosophers#>)
Group(
If bio:human(?x)
Then bio:mortal(?x)
)
Group(
bio:human(phil:Socrates)
)
)
```

4. Побудуйте 5-7 RIF RDF/OWL-правил до написаної вами онтології або використайте такі онтології: http://protege.cim3 .net/file/pub/ontologies/travel/travel.owl http://www.w3.org/TR/owl-guide/wine.rdf.

1. "Якщо винодільня знаходиться в AnjouRegion, то вона знаходиться в LoireRegion"
```
Document(
Prefix (wine <http: //example.com/wines#>)
Group(
If winery:locatedInAnjouRegion(?x)
Then winery:locatedInLoireRegion(?x)
  )
)
```

2. "Якщо вино пізднього збору, то це солодке вино"
```
Document(
Prefix (wine <http: //example.com/wines#>)
Group(
If wine:LateHarvest(?x)
Then wine:isSweet(?x)
  )
 )
```
3. "Якщо вино зроблене в AnjouRegion, то воно зроблене у Франції"
```
Document(
Prefix (wine <http: //example.com/wines#>)
Group(
If wine:madeInAnjouRegion(?x)
Then wine:madeInFrance(?x)
  )
 )
```
4. "Якщо вино сорту Мерло, то воно має червоний колір"
```
Document(
Prefix (wine <http: //example.com/wines#>)
Group(
If wine:Merlot(?x)
Then wine:hasRedColor(?x)
  )
 )
```

5. "Якщо вино сорту Шардоне, то воно має білий колір"
```
Document(
Prefix (wine <http: //example.com/wines#>)
Group(
If wine:Chardonnay(?x)
Then wine:hasWhiteColor(?x)
  )
 )
```