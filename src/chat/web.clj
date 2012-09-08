(ns chat.web
  (:use [compojure.core])
  (:require [compojure.handler :as handler]
            [ring.adapter.jetty :as ring]))

(defroutes main-routes
           (GET "/" [] "<h2>Hello, World!</h2>"))

(def application (handler/site main-routes))

(defn start [port]
  (ring/run-jetty #'application {:port (or port 8080) :join? false}))

(defn -main []
  (let [port (Integer. (System/getenv "PORT"))]
    (start port)))
