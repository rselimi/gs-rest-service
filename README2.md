how to push:

Install heroku cli tools using
- $brew install heroku

Login to heroku
- $heroku login
- use the account ---- and the password ----

Add heroku master repository
- $heroku git:remote -a smartpaymockbin

In the root folder of the project, use:
- $git subtree push --prefix initial heroku master

The application will automatically start in heroku

--

The only endpoint is:

POST /notifications
- Body: Notification from smartpay

GET /notifications
- Returns all stored notifications

GET /notifications/{pspReference}
- Returns the notification related to the pspReference

DELETE /notifications
- Deletes all the notifications 
