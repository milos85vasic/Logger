# Logger, version 1.0
Simple application logger for Kotlin with support for multiple log levels.
## Implementations
The following implementations are available:
### Console logger 
Each log level is printed using appropriate color to console output.
## How to use
- Import:
```
import net.milosvasic.logger.ConsoleLogger
```
- Instantiate:
```
val logger = ConsoleLogger()
```
- Use:
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

