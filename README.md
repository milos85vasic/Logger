# Logger
Simple application logger for Kotlin with support for multiple log levels.

## Implementations
The following implementations are available:
- Simple logger
- Console logger
- Filesystem logger
- Composite logger

## Simple logger 
Each log level is printed using appropriate color to console output containing various information

### How to use simple logger
- Import
```
import net.milosvasic.logger.SimpleLogger
```
- Instantiate
```
val logger = SimpleLogger()
```
- Use
```
logger.v(SomeClass::class, "This is a simple verbose log.")
```

## Console logger 
Each log level is printed using appropriate color to console output containing only message

### How to use console logger
- Import
```
import net.milosvasic.logger.ConsoleLogger
```
- Instantiate
```
val logger = ConsoleLogger()
```
- Use
```
logger.v(SomeClass::class, "This is a simple verbose log.")
```

## Filesystem logger
Logs are written on filesystem file.

By default file structure is created like this:
```
rootFolder/year/month/file.log
```
You can make folder structure flat:
```
logger.setStructured(false)
```
or change file extension:
```
logger.setLogFileExtension("txt")
```
Filesystem logger has maximal file size of 3 megabytes. When limit is reached file is split.
You can change that limit:
```
logger.setMaxLogFileSizeInMegabytes(10)
```

### How to use filesystem logger
- Import
```
import net.milosvasic.logger.FilesystemLogger
```
- Instantiate

To print logs in file located relatively to app you executed: 
```
val logger = FilesystemLogger()
```
or to provide destination folder where you want your log to be printed: 
```
val file = File("someRootFolder/etc/etc")
val logger = FilesystemLogger(file)
```
- Use
```
logger.v(SomeClass::class, "This is a simple verbose log.")
```

## Composite logger 
It is possible to instantiate logger that will forward log information to multiple loggers.

### How to use composite logger
- Import
```
import net.milosvasic.logger.CompositeLogger
import net.milosvasic.logger.FilesystemLogger
import net.milosvasic.logger.SimpleLogger
```
- Instantiate and configure
```
val tag = CompositeLogger::class

val logger = CompositeLogger()
val simple = SimpleLogger()
val filesystem = FilesystemLogger(getHome())

logger.addLogger(simple)
logger.addLogger(filesystem)
```
- Use
```
logger.v(tag, message)
```


## Supported log types
- Verbose
```
logger.v( ... ) // Printed in grey color.
```
- Debug
```
logger.d( ... ) // Printed in light yellow color.
```
- Information
```
logger.i( ... ) // Printed in cyan color.
```
- Confirmation
```
logger.c( ... ) // Printed in light green color.
```
- Notification
```
logger.n( ... ) // Printed in blue color.
```
- Warning
```
logger.w( ... ) // Printed in orange color.
```
- Error
```
logger.e( ... ) // Prined in red color.
```
# Deployment
If you wish to deploy Logger build to remote Maven repository you can like this:
```
./gradlew -Pdeploy=production -Pvariant=RELEASE  assemble
```
For each variant you need to create appropriate credentials file, for example:
```
credentials_production.gradle

or

credentials_development.gradle

or

credentials_whatever.gradle
```
Content of credentials file will be actually a copy of default_credentials.gradle with updated fields for:
 - FTP server address
 - FTP username
 - FTP password
 
If you are deploying production release use parameter:
```
-Pvariant=RELEASE
```
or leave out this parameter if building dev version.