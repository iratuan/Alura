import React, {Component} from 'react';

import {
  View,
  Text,
  Image,
  Dimensions,
  FlatList,
  StyleSheet,
  ImageBackground,
  TextInput,
  Picker
} from 'react-native';

import {keys} from '../../api/apikey';

const width = Dimensions.get('screen').width;

class FeedFotosRoverMars extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
      error: null,
    };
  }

  componentDidMount() {
    this.fetchData('Hover');
  }

  fetchData = () => {
    const date = new Date().toISOString().slice(0, 10);
    console.log(date);
    const url =
      'https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&page=1&max_date=2019-12-01&api_key=' + keys.API_KEY;
    this.setState({loading: true});
    fetch(url)
      .then(res => res.json())
      .then(result => {
        if (result.photos.length > 0) {
          let data = [];

          result.photos.forEach(item => {
            let info = {
              camera: item.camera,
              image: item.img_src,
              earth_date: item.earth_date,
              rover: item.rover,
            };
            data.push(info);
          });

          this.setState({
            data: data,
            error: result.error || null,
          });
        }
      })
      .catch(error => {
        this.setState({error});
      });
  };

  renderEmptyList = () => {
    return (
      <View>
        <Text>None result.</Text>
      </View>
    );
  };

  render() {
    return (
      <View style={styles.mainContainer}>
        <FlatList
          data={this.state.data}
          renderItem={({item}) => (
            <View style={styles.photoContainer}>
              <View style={styles.headerContainer}>
                <Image
                  source={require('../../../assets/images/nasa-logo.png')}
                  style={styles.userImage}
                />
                <Text style={{marginLeft: 10}}>
                  Rover:{item.rover.name} ({item.rover.status})
                </Text>
              </View>
              <ImageBackground
                style={styles.image}
                source={require('../../../assets/images/placeholder.png')}>
                <Image source={{uri: item.image}} style={styles.image} />
              </ImageBackground>
              <Text style={styles.description}>
                Rover: {item.rover.name}.{'\n'}
                Camera: {item.camera.full_name} ({item.camera.name}).{'\n'}
                Launch Date: {item.rover.launch_date}. Landing Date:{' '}
                {item.rover.landing_date}.
              </Text>
              <View>
                <Text style={styles.metaInfo}>
                  Earth date: {item.earth_date}. Total Photos:{' '}
                  {item.rover.total_photos}
                </Text>
              </View>
            </View>
          )}
          keyExtractor={(item, index) => index.toString()}
          ListEmptyComponent={this.renderEmptyList}
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  mainContainer: {
    marginTop: 20,
    marginLeft: 5,
    marginRight: 5,
  },

  photoContainer: {
    backgroundColor: '#f0f0f0',
    padding: 10,
    marginBottom: 10,
    borderRadius: 4,
  },

  headerContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 5,
  },

  image: {
    width: width - 40,
    height: width - 40,
    resizeMode: 'cover',
    borderRadius: 4,
  },

  userImage: {
    width: 60,
    height: 60,
    resizeMode: 'cover',
    borderRadius: 5,
  },

  description: {
    fontSize: 11,
    color: '#333',
    lineHeight: 18,
    marginTop: 10,
    marginBottom: 10,
  },

  metaInfo: {
    fontSize: 10,
    color: '#666',
    textAlign: 'right',
  },

  searchField: {
    borderBottomColor: '#22418d',
    borderBottomWidth: 2,
    flex: 1,
    width: width / 2 - 30,
  },
});

export default FeedFotosRoverMars;
