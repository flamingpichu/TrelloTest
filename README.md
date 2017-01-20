# TrelloTest

The purpose of this repository is to fulfill the requirements of the test task. Contained within are tests that cover the creation, modification and deletion of cards through the Trello API.

Before you begin you will need to edit the Constants.java file to use your own application key and user token which can be accessed via the following link:
https://trello.com/1/connect?key=YOUR_APPLICATION_KEY_HERE&name=TrelloTest&response_type=token&scope=read,write

Compile with the following command:
`javac -cp path\to\lib\*" TrelloClient.java TrelloRequest.java TrelloRequestFactory.java TrelloDelete.java TrelloPost.java TrelloPut.java CreateCardTest.java EditCardTest.java DeleteCardTest.java TrelloTestSuite.java TestRunner.java Constants.java`

We can run the entire suite of tests by running the TestRunner class via the following command (assuming the current directory is the src folder):
`java -cp .;"path\to\lib\*" TestRunner`
