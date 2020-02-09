(ns ring-app.home
  (:require
   [ring.util.http-response :refer :all])
  (:use hiccup.page hiccup.element))

(defn home-page []
  (html5
   [:html
    [:head
     (include-css "/css/bootstrap.min.css")]
    [:body
     [:h1 "Welcome Home"]
     [:button {:class "btn btn-primary"} "Hello"]
     (include-js "/js/jquery-3.4.1.min.js" "/js/bootstrap.js")]]))

(def routes
  ["/" {:get (fn [req] (content-type (ok (home-page)) "text/html; charset=utf-8"))}])
