import SwiftUI
import shared

struct ContentView: View {
    @State private var data: [TodoEntity] = []
    let appContainer: AppContainer
    init(appContainer: AppContainer) {
        self.appContainer = appContainer
    }

	var body: some View {
        List {
            ForEach(data, id: \.self) { todo in
                Text(todo.todo)
            }
        }.task {
            do {
                try await appContainer.appRepository.addTodos()
                let res = try await appContainer.appRepository.getTodos()
                data = res
            } catch {
                
            }
        }
	}
}
