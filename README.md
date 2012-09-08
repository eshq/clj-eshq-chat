# EventSource HQ Clojure Chat

This is a simple example of a chat application written in Clojure using
EventSource HQ to push chat messages to clients.

To install it on Heroku:

    git clone git://github.com/eshq/chat.git
    cd chat
    heroku create
    heroku addons:add eshq
    git push heroku master
