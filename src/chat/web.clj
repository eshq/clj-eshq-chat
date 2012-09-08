(ns chat.web
  (:use [compojure.core])
  (:require [ring.adapter.jetty :as ring]))

(defroutes main-routes
           (GET "/" [] "<h2>Hello, World!</h2>"))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (ring.run-jetty #'main-routes {:port port})))
