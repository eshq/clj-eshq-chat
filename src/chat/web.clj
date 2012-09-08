(ns chat.web
  (:use compojure.core
        chat.views
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as ring]
            [cheshire.core :as json]
            eshq))


(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})


(defn open [params]
  (json-response {:socket (eshq/open {:channel (params :channel)})}))


(defn message [params]
  (eshq/send {:channel "chat" :data (json/generate-string {
    :nick (params :nick)
    :msg  (params :msg)})}))


(defroutes main-routes
   (GET "/" [] (index-page))
   (POST "/eshq/socket" {params :params} (open params))
   (POST "/message" {params :params} (do (message params) "OK"))
   (route/resources "/")
   (route/not-found "Page not found"))


(def application 
  (-> (handler/site main-routes)
      (wrap-base-url)))


(defn start [port]
  (ring/run-jetty #'application {:port (or port 8080) :join? false}))


(defn -main []
  (let [port (Integer. (System/getenv "PORT"))]
    (start port)))
