(ns chat.views
  [:use [hiccup core page]])

(defn index-page []
  (html5
    [:head
     [:title "EventSource HQ Clojure Chat Example"]
     (include-css "/css/style.css")]
    [:body
     [:h1.header "ESHQ Chat"]

     [:div.chat.box
      [:div.container.box
       [:div#messages.messages.box]]
      [:div.chat-bar
       [:form#message
        [:input.box {:name "message" :placeholder "Type to chat"}]]]

      [:div#overlay.overlay]

      [:div.login-box
       [:form#login
        [:h3 "Choose a Nick"]
        [:input {:name "nick"}]
        [:button {:type "submit"} "Start Chatting"]]]]

     (include-js "https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js")
     (include-js "/js/json2.js")
     (include-js "https://app.eventsourcehq.com/es.js")
     (include-js "/js/chat.js")
    ]))
