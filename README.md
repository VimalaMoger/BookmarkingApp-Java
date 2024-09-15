
The project is about a Social bookmarking web aplication, where users can bookmark their favorite bookmarks, other features include to mark certain bookmarks as Kid-Friendly bookmarks, so that only kids can use, that is done by special type of Users called Editors, another feature was to share certain bookmarks with third party websites, used certain Java features to 
implement the web application. The project follows standards like MVC Design Pattern, View part simulates the browser, Data is stored in DataStore, data is simulated using java file and TDD approach(JUnit test), uses 2D arrays to manually store Book, Weblink, Movie data,  1D to store user data. This app uses MVC to manipulate and return data, Bookmarking or sharing a bookmark decision is made by randomization(Math.random()). Used Java.net classes to download the url content(only html pages),
implemented java IO to read and write to a file

Changes to the previous code:
Modification to arrays: arrays are replaced by ArrayList, modifications to data: Data is read from files
Background job created using multithreading- created runnable task, task to get all the weblinks, then download concurrently, once the job is done, wait for few seconds, continue with new set of values

