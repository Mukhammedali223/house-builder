# Report: Builder — House Implementation.Builder

Task: Implement the Builder pattern in Java and demonstrate the principles of Clean Code

The solution (briefly):
- File: `House.java` contains an immutable class `House` and a static nested `Builder'.
- Required fields: `address', `floors'. Options: `rooms', `area', `garage'.
- Validation is performed in `Builder.build()` (short private methods for readability)

Applied Clean Code Principles:
- Clear names (address, floors, rooms, area, garage)
- Small methods (validators are separated into separate methods)
- SRP: `House' — data storage; `Builder' — assembly and validation
- Immutability: `final` fields, no setters