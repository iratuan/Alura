import React, {Component} from 'react';
import {
  View,
  ImageBackground,
  Text,
  TextInput,
  Image,
  StyleSheet,
  TouchableHighlight,
} from 'react-native';

export default class Login extends Component {
  render() {
    return (
      <ImageBackground
        source={require('../../assets/background.png')}
        style={{width: '100%', height: '100%'}}>
        <View style={styles.viewContainer}>
          <Image
            source={require('../../assets/logo.png')}
            style={styles.logo}
          />
          <TextInput
            placeholder="Login"
            style={styles.textInput}
            placeholderTextColor="#fff"
          />
          <TextInput
            placeholder="Senha"
            secureTextEntry={true}
            style={styles.textInput}
            placeholderTextColor="#fff"
          />
          <TouchableHighlight style={styles.button} underlayColor="#c0c0c0">
            <Text
              style={{textAlign: 'center', color: '#fff', fontSize: 20}}
              onPress={() => this.props.navigation.navigate('Dashboard')}>
              Acessar
            </Text>
          </TouchableHighlight>
        </View>
      </ImageBackground>
    );
  }
}

const styles = StyleSheet.create({
  viewContainer: {
    flex: 1,
    justifyContent: 'center',
    padding: 30,
  },

  textInput: {
    lineHeight: 22,
    fontSize: 22,
    borderWidth: 2,
    marginBottom: 20,
    borderColor: '#fff',
    borderRadius: 5,
    paddingLeft: 10,
    paddingRight: 10,
    color: '#fff',
    textTransform: 'uppercase',
  },

  button: {
    borderWidth: 2,
    borderColor: '#fff',
    borderRadius: 5,
    backgroundColor: '#fdb813',
    padding: 15,
  },

  logo: {
    width: 200,
    resizeMode: 'contain',
    justifyContent: 'center',
    alignSelf: 'center',
    marginBottom: 40,
  },
});
