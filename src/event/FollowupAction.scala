package event

class FollowupAction(action: Action) {
}

object FollowupAction {
  object PROCEED extends FollowupAction(null)
  object RETRY extends FollowupAction(null)
}