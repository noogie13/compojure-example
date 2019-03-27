(ns solb.compojure
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.params :refer [wrap-params]]
            [ring.adapter.jetty :as jetty]))

(defroutes app-routes
  (GET "/" [] "main page here!!")
  (GET "/user/:id" [id] (str "hihihi " id))
  (POST "/post" [:as req] (str (:params req)))
  (route/not-found "404 page"))

(def app
  (-> app-routes
      (wrap-params)))

(defonce server (jetty/run-jetty #'app {:port 5000 :join? false}))

(defn stop-server
  []
  (.stop server))

(defn -main
  [& args]
  (.start server))
