# elastic-recurring-plugin

Allow to work in ES with some features of recurrent dates defined in [rfc2445](https://www.ietf.org/rfc/rfc2445.txt). This plugin adds a new type named *recurring* and the native scripts: *nextOccurrence*, *hasOccurrencesAt*, *occurBetween* and *isOccurring*.

## Getting start

### Compiling and installing plugin
 
Generating zip file, execute command bellow, the file will be created in folder `target\releases`.

```$mvn clean package```

To installing plugin in elasticsearch, run this command in your elasticsearch server.

```$bin/plugin install recurring-plugin-0.1.zip```

## Recurring Type
Mapper type called _recurring_ to support recurrents dates. The declaration looks as follows:
```
{
    "event" : {
        "properties" : {
            "recurrent_date" : {
                "type" : "recurring"
            }
        }
    }
}
```
The above mapping defines a _recurring_, which accepts the follow format:
```
{
    "event" : {
        "recurrent_date" : {
            "start_date" : "2016-12-25",
            "end_date" : null,
            "rrule": "RRULE:FREQ=YEARLY;BYMONTH=12;BYMONTHDAY=25"
        }
    }
}
```

## Native scripts

### nextOccurrence

Script field returns date of next occurrence of event in yyyy-MM-dd.

*Parameters:*
- *field* - Name of property, type must be _recurring_.

### hasOccurrencesAt

Script field returns `true` if event occurrs in determinated date.

*Parameters:*
- *field* - Name of property, type must be _recurring_.
- *date* - Date 

### occurBetween

Script field returns `true` if event occurrs in determinated range of date.

*Parameters:*  
- *field* - Name of property, type must be _recurring_.
- *start* - Starting date inclusive.
- *end* - Ending date inclusive.

### isOccurring

Script field returns `true` if event is occurring considering server date.

*Parameters:*  
- *field* - Name of property, type must be _recurring_.
