
The project is about a Social bookmarking web aplication, where users can bookmark their favorite book, weblink, or movie, other features include to mark certain bookmarks as Kid-Friendly, so that only kids can use, that is done by special type of Users called Editors, another feature was to share certain bookmarks with third party websites. Bookmarking or sharing a bookmark decision is made by randomization. Used Java.net classes to download the url content(only html pages). 

The project follows standards like MVC Design Pattern, View part simulates the browser, Data is stored in DataStore. Initially, used 2D arrays to manually store Book, Weblink, Movie data,  1D to store user data.

Changes to the previous code:
Modification to arrays: arrays are replaced with ArrayList, modifications to data: Data is read from files. Implemented Java IO to read and write to a file and developed JUnit test cases.
Background job created using multithreading - created runnable task, task to get all the weblinks, then download them concurrently, once the job is done, wait for few seconds, continue with new set of values

