(ns ring-app.home
  (:require
   [ring-app.util :as util])
  (:use hiccup.page hiccup.element))

(defn home-page [request]
  (util/layout
   (html5
    [:h1 "Welcome Home"]
    [:button {:class "btn btn-primary"} "Hello"])))

(def routes
  ["/" {:get home-page}])
