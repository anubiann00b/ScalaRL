package event

import event.action.Action

class FollowupAction(val action: Action) {
}

object FollowupAction {
  object PROCEED extends FollowupAction(null)
  object RETRY extends FollowupAction(null)
}