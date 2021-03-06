(defproject matthiasn/trailing-mouse-pointer "0.1.0-SNAPSHOT"
  :description "Sample application built with systems-toolbox library"
  :url "https://github.com/matthiasn/systems-toolbox"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.clojure/tools.namespace "0.2.10"]
                 [ch.qos.logback/logback-classic "1.1.2"]
                 [hiccup "1.0.5"]
                 [hiccup-bridge "1.0.1"]
                 [garden "1.2.5"]
                 [clj-pid "0.1.1"]
                 [matthiasn/systems-toolbox "0.2.15"]
                 [reagent "0.5.0"]
                 [incanter "1.5.6"]
                 [clj-time "0.9.0"]
                 [org.clojure/clojurescript "0.0-3308"]]

  :source-paths ["src/clj/"]

  :clean-targets ^{:protect false} ["resources/public/js/build/"]

  :main example.core

  :plugins [[lein-cljsbuild "1.0.6"]
            [lein-figwheel "0.3.7" :exclusions [org.clojure/clojure org.codehaus.plexus/plexus-utils]]
            [codox "0.8.10" :exclusions [org.clojure/clojure]]]

  :figwheel {:server-port 3450
             :css-dirs ["resources/public/css"]}

  :cljsbuild {:builds [{:id           "dev"
                        :source-paths ["src/cljs" "env/dev/cljs"]
                        :figwheel     true
                        :compiler     {:main          "example.dev"
                                       :asset-path    "js/build"
                                       :optimizations :none
                                       :output-dir    "resources/public/js/build/"
                                       :output-to     "resources/public/js/build/example.js"
                                       :source-map    true}}
                       {:id           "release"
                        :source-paths ["src/cljs"]
                        :figwheel     true
                        :compiler     {:main          "example.core"
                                       :asset-path    "js/build"
                                       :output-to     "resources/public/js/build/example.js"
                                       :optimizations :advanced}}]})
