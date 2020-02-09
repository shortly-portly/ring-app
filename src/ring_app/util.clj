(ns ring-app.util
  (:require [ring.util.http-response :refer :all])
  (:use hiccup.page hiccup.element))

(defn layout [content]
  "A default layout page"
(content-type (ok
  (html5
   [:html
    [:head
     (include-css "/css/bootstrap.min.css")]
    [:body
     content
     (include-js "/js/jquery-3.4.1.min.js" "/js/bootstrap.js")]]))
              "text/html; charset=utf-8"))
