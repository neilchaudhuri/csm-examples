let kubernetes =
      https://raw.githubusercontent.com/dhall-lang/dhall-kubernetes/master/package.dhall sha256:0d7e7c321164921d742e2b23c5cc79e59ff02bd77106b799322bb14f12c29f91

let template =
      kubernetes.PodTemplateSpec::{
      , metadata = Some kubernetes.ObjectMeta::{
            , name = Some "lookout-add-service"
            , annotations = Some [{mapKey = "description", mapValue = "Sample OpenShift Template"}, {mapKey = "iconClass", mapValue = "icon-openshift"}]
      }
}

let deployment =
      kubernetes.Deployment::{
      , metadata = kubernetes.ObjectMeta::{ name = Some "nginx" }
      , spec = Some kubernetes.DeploymentSpec::{
        , selector = kubernetes.LabelSelector::{
          , matchLabels = Some (toMap { name = "nginx" })
          }
        , replicas = Some 2
        , template = template
      }
}


in deployment