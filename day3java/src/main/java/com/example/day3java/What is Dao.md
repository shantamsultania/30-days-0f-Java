# DAO - Data Access Object

This is used to separate low-level data accessing API or operations from high-level business services. In short to make the Data Access easier and more secure.

It has 3 parts just Like MVC :

1. Data Access Object Interface - This interface defines the standard operations to be performed on a model object(s).
2. Data Access Object concrete class - This class implements the above interface. This class is responsible to get data from a data source which can be database / XML or any other storage mechanism.
3. Model Object or Value Object - This object is a simple POJO containing get/set methods to store data retrieved using DAO class.

## Use Case 

Mainly to handle Database Queries or if Data changes are required frequently
