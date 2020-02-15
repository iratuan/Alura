import {StyleSheet, Dimensions} from 'react-native';

const width = Dimensions.get('screen').width;

export default styles = StyleSheet.create({
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
