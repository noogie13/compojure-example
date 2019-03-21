(ns solb.compojure
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]))

(defroutes app
  (GET "/" [] "main page here!!")
  (route/not-found "404 page"))

(defonce server (jetty/run-jetty #'app {:port 5000 :join? false}))

(defn stop-server
  []
  (.stop server))

(defn -main
  [& args]
  (.start server))
