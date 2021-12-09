import {Text, TouchableOpacity, View} from 'react-native'
import RNShake from 'react-native-shake'
import React, {memo} from 'react'

export const DebugtoolsView: React.FC = memo(() => {
  return (
    <View>
      <TouchableOpacity
        style={{backgroundColor: 'orange'}}
        onPress={() => {
          DebugTools.callback()
        }}>
        <Text>Press</Text>
      </TouchableOpacity>
    </View>
  )
})

interface DebugToolsInitParams {
  t: (key: string, options?: any) => string
  callback: () => void
}

export class DebugTools {
  private static instance: DebugTools

  static init(params: DebugToolsInitParams) {
    this.instance = new DebugTools(params)
    console.log('🔦 Shake initialized')
    RNShake.addListener(() => {
      console.log('🔦 SHAKE')
    })
  }

  private static get params(): DebugToolsInitParams {
    return this.assertInstance().initParams
  }

  static get t(): (key: string, options?: any) => string {
    return this.params.t
  }

  static get callback(): () => void {
    return this.params.callback
  }

  private static assertInstance(): DebugTools {
    if (!DebugTools.instance) {
      throw new Error(
        'DebugTools not initialized. Invoke DebugTools.init(...) to initialize debug tools.',
      )
    }
    return DebugTools.instance
  }

  constructor(private initParams: DebugToolsInitParams) {}
}
