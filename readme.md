# CS Dashboard

## intro
this is just a simple POC to retrieve and display Credit Values from a webservice

## architecture
followed the MVVM pattern, in which i'll separated the business logci from the Views
and use the Repository patterns to decouple the fetch from the VM as well.


## Libraries used and Reason
- Dagger : for IoC and help to decouple the code
- Retrofit : to network layer its easy, simple, clean, has lot of documentation/support online
- Mockito/Robolectric : for testing the business logic