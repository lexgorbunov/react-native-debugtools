import {
  EmitterSubscription,
  NativeEventEmitter,
  NativeModules,
} from 'react-native'

const {RNShakeEvent} = NativeModules.RNShakeEvent
if (!RNShakeEvent) {
  throw new Error('DT Shaker Linking error')
}

const shakerEventEmitter = new NativeEventEmitter(RNShakeEvent)

export const DebugToolsShaker: {
  readonly addListener: (
    callback: () => void | undefined,
  ) => EmitterSubscription
  readonly removeAllListeners: () => void
  readonly removeCurrentListener: () => void
} = {
  addListener: (callback: () => void | undefined) =>
    shakerEventEmitter.addListener('ShakeEvent', callback),
  removeAllListeners: () => {
    shakerEventEmitter.removeAllListeners('ShakeEvent')
  },
  removeCurrentListener: () => {
    shakerEventEmitter.removeCurrentListener()
  },
}
