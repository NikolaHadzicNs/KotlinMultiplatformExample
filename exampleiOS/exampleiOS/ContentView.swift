import SwiftUI
import shared

struct ContentView: View {
    @State private var data: [TodoEntity] = []
    @State private var site: String = ""
    let appContainer: AppContainer
    init(appContainer: AppContainer) {
        self.appContainer = appContainer
    }

	var body: some View {
        List {
            ForEach(data, id: \.self) { todo in
                Text(todo.todo)
            }
            Text(site)
        }.task {
            do {
                try await appContainer.appRepository.addTodos()
                let res = try await appContainer.appRepository.getTodos()
                data = res
                let siteData = try await appContainer.appRepository.getDataFromApi()
                site = siteData
            } catch {
                
            }
        }
	}
}
