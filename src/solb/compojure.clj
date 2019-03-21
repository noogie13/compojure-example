(ns solb.compojure
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]))

(defroutes app
  (GET "/" [] "main page here!!")
  (GET "/user/:id" [id] (str "hihihi " id))
  (POST "/post" [:as req] (str req))
  (route/not-found "404 page"))

(defonce server (jetty/run-jetty #'app {:port 5000 :join? false}))

(defn stop-server
  []
  (.stop server))

(defn -main
  [& args]
  (.start server))
