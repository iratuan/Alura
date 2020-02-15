import React, {Component} from 'react';

import {
  View,
  Text,
  Image,
  Dimensions,
  FlatList,
  ImageBackground,
  Picker,
} from 'react-native';

import {keys} from '../../api/apikey';
import styles from '../../assets/styles/styles';
import TopMenu from '../../components/TopMenu/TopMenu';

const width = Dimensions.get('screen').width;

class FeedFotosRoverMars extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
      error: null,
      rover: 'curiosity',
    };
  }

  componentDidMount() {
    this.fetchData('curiosity');
  }

  fetchData = (rover) => {
    const date = new Date().toISOString().slice(0, 10);
    let _rover = null;
    if(rover){
      this.setState({rover:rover});
      _rover = rover;
    }
    
    const url =
      'https://api.nasa.gov/mars-photos/api/v1/rovers/' +
      _rover +
      '/photos?sol=1000&page=1&max_date=' +
      date +
      '&api_key=' +
      keys.API_KEY;
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

  renderHeader = () => {
    return (
      <View style={{marginBottom: 20}}>
        <Picker
          selectedValue={this.state.rover}
          style={{height: 50, width: width - 40}}
          onValueChange={this.fetchData.bind(this)}>
          <Picker.Item label="Curiosity" value="curiosity" />
          <Picker.Item label="Opportunity" value="opportunity" />
          <Picker.Item label="Spirit" value="spirit" />
        </Picker>
      </View>
    );
  };

  render() {
    return (
      <View style={styles.mainContainer}>
        <View>
          <TopMenu />
        </View>
        <FlatList
          data={this.state.data}
          renderItem={({item}) => (
            <View style={styles.photoContainer}>
              <View style={styles.headerContainer}>
                <Image
                  source={require('../../assets/images/nasa-logo.png')}
                  style={styles.userImage}
                />
                <Text style={{marginLeft: 10}}>
                  Rover:{item.rover.name} ({item.rover.status})
                </Text>
              </View>
              <ImageBackground
                style={styles.image}
                source={require('../../assets/images/placeholder.png')}>
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
          ListHeaderComponent={this.renderHeader}
        />
      </View>
    );
  }
}



export default FeedFotosRoverMars;
