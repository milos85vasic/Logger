# Logger, version 1.1.2
Simple application logger for Kotlin with support for multiple log levels.

## Implementations
The following implementations are available:
- Console logger
- Filesystem logger

## Console logger 
Each log level is printed using appropriate color to console output.

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
logger.structured = false
```
or change file extension:
```
logger.extension = "txt"
```

### How to use console logger
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

