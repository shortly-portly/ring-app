(ns ring-app.home
  (:require
   [ring.util.http-response :refer :all])
  (:use hiccup.page hiccup.element))

(defn home-page []
  (html5
   [:html
    [:head]
    [:body
     [:h1 "Welcome Home"]
     (include-js "/wibble.js")]]))

(def routes
  ["/" {:get (fn [req] (content-type (ok (home-page)) "text/html; charset=utf-8"))}])
