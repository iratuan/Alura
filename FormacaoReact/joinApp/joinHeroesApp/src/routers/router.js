import React from 'react';
import {createAppContainer} from 'react-navigation';
import {createDrawerNavigator} from 'react-navigation-drawer';
import {createStackNavigator} from 'react-navigation-stack';
import {Image, View} from 'react-native';

import Login from '../pages/Login';
import Dashboard from '../pages/Dashboard';

const AppNavigator = createStackNavigator({
  Login: {
    screen: Login,
    navigationOptions: {
      headerShown: false,
    },
  },
  Dashboard: {
    screen: Dashboard,
    navigationOptions: {
      headerTitle: () => (
        <View style={{flexDirection: 'row'}}>
          <Image
            source={require('../../assets/logo.png')}
            style={{
              height: 30,
              resizeMode: 'contain',
              justifyContent: 'flex-end',
            }}
          />
        </View>
      ),
      headerStyle: {
        backgroundColor: '#00739d',
      },
      headerTitleStyle: {
        flexDirection: 'column',
        color: '#fff',
        alignSelf: 'flex-end',
      },
    },
  },
});

export default Router = createAppContainer(AppNavigator);
