(ns ring-app.core
  (:require [reitit.core :as r]
            [reitit.ring :as ring]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.content-type :refer [wrap-content-type]]
            [ring-app.home :as home]))

(def home-routes
  [["/" {:get (fn [req] {:status 200 :body "ok"})}]])

(def app
  (ring/ring-handler
   (ring/router ["/home" home/routes])
   (ring/routes
    (ring/redirect-trailing-slash-handler)
    (ring/create-resource-handler {:path "/"})
    (ring/create-default-handler))))

(defn start []
  (jetty/run-jetty #'app {:port 3000, :join? false})
  (println "Server running on port 3000"))

(start)
