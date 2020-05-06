import React, { Component } from 'react';
import { View, Text, Button } from 'react-native';
import ImagePicker from 'react-native-image-picker';

class ImagePickerComponent extends Component {

  handeChoosePhoto = () => {
    const options = {};
    ImagePicker.lauchImageLibrary(options,response => {
        console.log("Response: ", response)
    });
  }

  render() {
    return (
      <View>
        <Button title="Escolha uma foto"
        onPress={this.handeChoosePhoto} />
      </View>
    );
  }
}

export default ImagePickerComponent;
