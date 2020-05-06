/**
 * @format
 */

import {AppRegistry} from 'react-native';
import FeedFotosNasa from './src/pages/FeedFotosNasa/FeedFotosNasa';
import FeedFotosRoverMars from './src/pages/FeedFotosRoverMars/FeedFotosRoverMars';
import {name as appName} from './app.json';

AppRegistry.registerComponent(appName, () => FeedFotosRoverMars);
