import './App.css';
import LearningComponent from './components/learning-example/LearningComponent';

function App() {
  return (
    <div className="App">
      <LearningComponent />
    </div>
  );
}


// React에서 기본적으로 제공되는 Component 클래스를 상속받아 만든 컴포넌트는 class component라고 합니다. 
// 반면에, functional component는 함수형으로 작성된 컴포넌트를 말합니다.
// class component는 Component 클래스를 상속받기 때문에 state와 lifecycle methods를 사용할 수 있습니다. 
// state는 컴포넌트의 내부 상태를 관리하며, lifecycle methods는 컴포넌트가 생성, 업데이트, 제거되는 과정에서 실행되는 메서드입니다. 
// class component를 사용하면 더 많은 기능을 구현할 수 있지만, 코드의 복잡성도 높아지는 경향이 있습니다.
// 반면에, functional component는 함수를 사용하기 때문에 state와 lifecycle methods를 직접 사용할 수는 없습니다. 
// 하지만, 최근 버전의 React에서는 Hooks라는 기능을 도입하여 state와 lifecycle methods를 함수형 컴포넌트에서도 사용할 수 있게 되었습니다. 
// functional component를 사용하면 코드의 간결성이 높아지며, 컴포넌트의 성능도 더욱 향상될 수 있습니다.
// 따라서, class component는 기능이 많은 대신 코드가 복잡해지는 경향이 있고, functional component는 코드가 간결해지지만 기능이 제한될 수 있습니다. 
// 최근 React에서는 functional component와 Hooks를 사용하는 것을 권장하고 있습니다.
// react는 jsx로 작성된다(javascript xml),
// babel을 이용해서 이전 버전의 브라우저에서도 실행될 수 있도록 코드가 컴파일된다.
// 내부에서는 jsx가 javascript로 번역된다.


// return은 ()안에 conponent이름은 대문자로 시작(파스칼 케이스) 여야한다.






export default App;
