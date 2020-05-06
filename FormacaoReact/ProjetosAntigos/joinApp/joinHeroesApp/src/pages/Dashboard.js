import React, {Component} from 'react';
import {View, Text, ImageBackground, StyleSheet} from 'react-native';
import Camera from '../components/CameraComponent';
import ImagePickerComponent from '../components/ImagePickerComponent';

class Dashboard extends Component {
  render() {
    return (
      <ImageBackground
        source={require('../../assets/background.png')}
        style={{width: '100%', height: '100%'}}>
        <View style={styles.viewContainer}>
          <Camera />
          <ImagePickerComponent />
        </View>
      </ImageBackground>
    );
  }
}
const styles = StyleSheet.create({
  viewContainer: {
    flex: 1,
    padding: 30,
  },
});
export default Dashboard;
