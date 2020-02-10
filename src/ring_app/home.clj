(ns ring-app.home
  (:require
   [ring-app.util :as util]
   [ring.middleware.params :as params]
   [ring.util.http-response :as response]
   [struct.core :as struct])
  (:use hiccup.page hiccup.element hiccup.form))

(defn home-page [request]
  (util/layout
   (html5
    [:h1 "Welcome Home"]
    [:button {:class "btn btn-primary"} "Hello"]
    (form-to [:post "/home/post"]
             (text-field "username")
             (submit-button "Submit")))))
(def user-schema
  [[:username
    struct/required
    struct/string
    {:username "username must be greater than 3 characters"
     :validate #(> (count %) 3)}]])

(defn validate-user [params]
  (first (struct/validate params user-schema)))

(defn post-data [{:keys [params]}]
  (println (str "Params: " params))
  (println (str "Errors: " (validate-user params)))
  (if-let [errors (validate-user params)]
    (-> (response/found "/home")
        (assoc :flash (assoc params :errors errors)))
    (util/layout
     (html5
      [:h1 "Thanks"]))))





(def routes
  [""
   {:middleware [params/wrap-params]}
   ["/" {:get home-page}]
   ["/post" {:post post-data}]])
